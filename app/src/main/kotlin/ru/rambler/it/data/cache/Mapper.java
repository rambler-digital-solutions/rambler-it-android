package ru.rambler.it.data.cache;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import ru.rambler.it.data.dto.ParentDto;


public class Mapper {
    private final Field[] destFields;
    private final Map<String, Field> assignableSourceFieldsMap;
    private final Map<String, Field> notAssignableSourceFieldsMap;
    private final Map<String, Field> notMappedSourceFieldsMap;

    public Mapper(Object source, Object dest) {
        Class sourceClass = source.getClass();
        Class destClass = dest.getClass();

        destFields = destClass.getDeclaredFields();
        Map<String, Field> destFieldsMap = new HashMap<>(destFields.length);
        for (Field f : destFields) {
            destFieldsMap.put(f.getName(), f);
            f.setAccessible(true);
        }

        Field[] sourceFields = sourceClass.getDeclaredFields();
        assignableSourceFieldsMap = new HashMap<>(sourceFields.length);
        notAssignableSourceFieldsMap = new HashMap<>();
        notMappedSourceFieldsMap = new HashMap<>();
        for (Field sf : sourceFields) {
            Field df = destFieldsMap.get(sf.getName());
            if (df != null) {
                if (df.getType().isAssignableFrom(sf.getType())) {
                    assignableSourceFieldsMap.put(sf.getName(), sf);
                } else {
                    notAssignableSourceFieldsMap.put(sf.getName(), sf);
                }
                sf.setAccessible(true);
            } else {
                notMappedSourceFieldsMap.put(sf.getName(), sf);
            }
        }

        map(source, dest);
    }

    private void map(Object source, Object dest) {
        for (Field destField : destFields) {
            Field sourceField = assignableSourceFieldsMap.get(destField.getName());
            if (sourceField != null) {
                try {
                    mapField(sourceField, destField, source, dest);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if ((sourceField = notAssignableSourceFieldsMap.get(destField.getName())) != null) {
                mapNotAssignableField(sourceField, destField, source, dest);
            }
        }
        for (Field sourceField : notMappedSourceFieldsMap.values()) {
            mapNotMappedField(sourceField, source, dest);
        }
    }

    protected Object mapField(Field sourceField, Field destField, Object source, Object dest) throws IllegalAccessException {
        Object value = sourceField.get(source);
        destField.set(dest, value);
        return value;
    }

    protected void mapNotAssignableField(Field sourceField, Field destField, Object source, Object dest) {
        try {
            Object sourceInnerObject = sourceField.get(source);
            if (sourceInnerObject instanceof ParentDto) {
                Object destInnerObject = TypesMap.INSTANCE.makeDbo((ParentDto)sourceInnerObject);
                new Mapper(sourceInnerObject, destInnerObject);
                destField.set(dest, destInnerObject);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void mapNotMappedField(Field sourceField, Object source, Object dest) {

    }
}
