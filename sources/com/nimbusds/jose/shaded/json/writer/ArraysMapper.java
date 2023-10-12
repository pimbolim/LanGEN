package com.nimbusds.jose.shaded.json.writer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArraysMapper<T> extends JsonReaderI<T> {
    public static JsonReaderI<Boolean[]> MAPPER_BOOL = new ArraysMapper<Boolean[]>((JsonReader) null) {
        public Boolean[] convert(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) next).booleanValue());
                    } else if (next instanceof Number) {
                        boolArr[i] = Boolean.valueOf(((Number) next).intValue() != 0);
                    } else {
                        throw new RuntimeException("can not convert " + next + " toBoolean");
                    }
                    i++;
                }
            }
            return boolArr;
        }
    };
    public static JsonReaderI<Byte[]> MAPPER_BYTE = new ArraysMapper<Byte[]>((JsonReader) null) {
        public Byte[] convert(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Byte) {
                        bArr[i] = (Byte) next;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) next).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    };
    public static JsonReaderI<Character[]> MAPPER_CHAR = new ArraysMapper<Character[]>((JsonReader) null) {
        public Character[] convert(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    chArr[i] = Character.valueOf(next.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    };
    public static JsonReaderI<Double[]> MAPPER_DOUBLE = new ArraysMapper<Double[]>((JsonReader) null) {
        public Double[] convert(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Double) {
                        dArr[i] = (Double) next;
                    } else {
                        dArr[i] = Double.valueOf(((Number) next).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    };
    public static JsonReaderI<Float[]> MAPPER_FLOAT = new ArraysMapper<Float[]>((JsonReader) null) {
        public Float[] convert(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        fArr[i] = (Float) next;
                    } else {
                        fArr[i] = Float.valueOf(((Number) next).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    };
    public static JsonReaderI<Integer[]> MAPPER_INT = new ArraysMapper<Integer[]>((JsonReader) null) {
        public Integer[] convert(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Integer) {
                        numArr[i] = (Integer) next;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) next).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    };
    public static JsonReaderI<Long[]> MAPPER_LONG = new ArraysMapper<Long[]>((JsonReader) null) {
        public Long[] convert(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        lArr[i] = (Long) next;
                    } else {
                        lArr[i] = Long.valueOf(((Number) next).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    };
    public static JsonReaderI<boolean[]> MAPPER_PRIM_BOOL = new ArraysMapper<boolean[]>((JsonReader) null) {
        public boolean[] convert(Object obj) {
            List<Boolean> list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            int i = 0;
            for (Boolean booleanValue : list) {
                zArr[i] = booleanValue.booleanValue();
                i++;
            }
            return zArr;
        }
    };
    public static JsonReaderI<byte[]> MAPPER_PRIM_BYTE = new ArraysMapper<byte[]>((JsonReader) null) {
        public byte[] convert(Object obj) {
            List<Number> list = (List) obj;
            byte[] bArr = new byte[list.size()];
            int i = 0;
            for (Number byteValue : list) {
                bArr[i] = byteValue.byteValue();
                i++;
            }
            return bArr;
        }
    };
    public static JsonReaderI<char[]> MAPPER_PRIM_CHAR = new ArraysMapper<char[]>((JsonReader) null) {
        public char[] convert(Object obj) {
            List<Object> list = (List) obj;
            char[] cArr = new char[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                cArr[i] = obj2.toString().charAt(0);
                i++;
            }
            return cArr;
        }
    };
    public static JsonReaderI<double[]> MAPPER_PRIM_DOUBLE = new ArraysMapper<double[]>((JsonReader) null) {
        public double[] convert(Object obj) {
            List<Number> list = (List) obj;
            double[] dArr = new double[list.size()];
            int i = 0;
            for (Number doubleValue : list) {
                dArr[i] = doubleValue.doubleValue();
                i++;
            }
            return dArr;
        }
    };
    public static JsonReaderI<float[]> MAPPER_PRIM_FLOAT = new ArraysMapper<float[]>((JsonReader) null) {
        public float[] convert(Object obj) {
            List<Number> list = (List) obj;
            float[] fArr = new float[list.size()];
            int i = 0;
            for (Number floatValue : list) {
                fArr[i] = floatValue.floatValue();
                i++;
            }
            return fArr;
        }
    };
    public static JsonReaderI<int[]> MAPPER_PRIM_INT = new ArraysMapper<int[]>((JsonReader) null) {
        public int[] convert(Object obj) {
            List<Number> list = (List) obj;
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Number intValue : list) {
                iArr[i] = intValue.intValue();
                i++;
            }
            return iArr;
        }
    };
    public static JsonReaderI<long[]> MAPPER_PRIM_LONG = new ArraysMapper<long[]>((JsonReader) null) {
        public long[] convert(Object obj) {
            List<Number> list = (List) obj;
            long[] jArr = new long[list.size()];
            int i = 0;
            for (Number intValue : list) {
                jArr[i] = (long) intValue.intValue();
                i++;
            }
            return jArr;
        }
    };
    public static JsonReaderI<short[]> MAPPER_PRIM_SHORT = new ArraysMapper<short[]>((JsonReader) null) {
        public short[] convert(Object obj) {
            List<Number> list = (List) obj;
            short[] sArr = new short[list.size()];
            int i = 0;
            for (Number shortValue : list) {
                sArr[i] = shortValue.shortValue();
                i++;
            }
            return sArr;
        }
    };
    public static JsonReaderI<Short[]> MAPPER_SHORT = new ArraysMapper<Short[]>((JsonReader) null) {
        public Short[] convert(Object obj) {
            List list = (List) obj;
            Short[] shArr = new Short[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Short) {
                        shArr[i] = (Short) next;
                    } else {
                        shArr[i] = Short.valueOf(((Number) next).shortValue());
                    }
                    i++;
                }
            }
            return shArr;
        }
    };

    public T convert(Object obj) {
        return obj;
    }

    public ArraysMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    public Object createArray() {
        return new ArrayList();
    }

    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    public static class GenericMapper<T> extends ArraysMapper<T> {
        final Class<?> componentType;
        JsonReaderI<?> subMapper;

        public GenericMapper(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.componentType = cls.getComponentType();
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [T, java.lang.Object[]] */
        public T convert(Object obj) {
            List<Object> list = (List) obj;
            ? r0 = (Object[]) Array.newInstance(this.componentType, list.size());
            int i = 0;
            for (Object obj2 : list) {
                r0[i] = obj2;
                i++;
            }
            return r0;
        }

        public JsonReaderI<?> startArray(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.componentType);
            }
            return this.subMapper;
        }

        public JsonReaderI<?> startObject(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper(this.componentType);
            }
            return this.subMapper;
        }
    }
}
