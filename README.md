
These files used are to change behavior of Moshi, Issue #843(Ignore null value and use the default value when deserializing from json string)

### Issue was discussed here
https://github.com/square/moshi/issues/843

Moshi is a great JSON library for Kotlin. It understands Kotlin’s non-nullable types and default parameter values. When you use Kotlin with Moshi you may use reflection, codegen, or both.

We can change the default behavior using Reflection, So I ended up not using @JsonClass(generateAdapter = true) and Codegen. I gave up on that.

**Used second option Reflection**

```
val moshi = Moshi.Builder()
    // ... add your own JsonAdapters and factories ...
    .add(KotlinJsonAdapterFactory())
    .build()
```

**Made a copy of ```KotlinJsonAdapter``` -> ```MyKotlinJsonAdapter```**

[MyKotlinJsonAdapter](https://github.com/uchhabra3/Moshi-Issue-843-Solution/blob/master/MyKotlinJsonAdapter)

**Commented code where it checks if null values are present in JSON for non-null Properties**

``` MyKotlinJsonAdapter```


```
//            if (values[index] == null && !binding.property.returnType.isMarkedNullable) {
//                throw JsonDataException(
//                    "Non-null value '${binding.property.name}' was null at ${reader.path}")
//            }
```

**Renamed ```KotlinJsonAdapterFactory``` -> ```MyKotlinJsonAdapterFactory```** 

**Made changes in IndexedParameterMap that is responsible for adding default values if value is ABSENT in JSON**
**Treated null values same as ABSENT_VALUE**


**Before**

```
  class IndexedParameterMap(val parameterKeys: List<KParameter>, val parameterValues: Array<Any?>)
    : AbstractMap<KParameter, Any?>() {

    override val entries: Set<Entry<KParameter, Any?>>
      get() {
        val allPossibleEntries = parameterKeys.mapIndexed { index, value ->
          SimpleEntry<KParameter, Any?>(value, parameterValues[index])
        }
        return allPossibleEntries.filterTo(LinkedHashSet<Entry<KParameter, Any?>>()) {
          it.value !== ABSENT_VALUE
        }
      }

    override fun containsKey(key: KParameter) = parameterValues[key.index] !== ABSENT_VALUE

    override fun get(key: KParameter): Any? {
      val value = parameterValues[key.index]
      return if (value !== ABSENT_VALUE) value else null
    }
  }
```

**After**
```
    class IndexedParameterMap(val parameterKeys: List<KParameter>, val parameterValues: Array<Any?>)
        : AbstractMap<KParameter, Any?>() {

        override val entries: Set<Entry<KParameter, Any?>>
            get() {
                val allPossibleEntries = parameterKeys.mapIndexed { index, value ->
                    SimpleEntry<KParameter, Any?>(value, parameterValues[index])
                }
                return allPossibleEntries.filterTo(LinkedHashSet<Entry<KParameter, Any?>>()) {
                    it.value !== ABSENT_VALUE && it.value!=null
                }
            }

        override fun containsKey(key: KParameter) = parameterValues[key.index] !== ABSENT_VALUE && parameterValues[key.index] !=null

        override fun get(key: KParameter): Any? {
            val value = parameterValues[key.index]
            return if (value !== ABSENT_VALUE) value else null
        }
    }
```



**Made a copy of ```StandardJsonAdapters``` -> ```MyStandardJsonAdapters```**

[MyStandardJsonAdapters](https://github.com/uchhabra3/Moshi-Issue-843-Solution/blob/master/MyStandardJsonAdapters)

**Made changes by making adapters null-safe**

**Before**

```
if (!annotations.isEmpty()) return null;
      if (type == boolean.class) return BOOLEAN_JSON_ADAPTER;
      if (type == byte.class) return BYTE_JSON_ADAPTER;
      if (type == char.class) return CHARACTER_JSON_ADAPTER;
      if (type == double.class) return DOUBLE_JSON_ADAPTER;
      if (type == float.class) return FLOAT_JSON_ADAPTER;
      if (type == int.class) return INTEGER_JSON_ADAPTER;
      if (type == long.class) return LONG_JSON_ADAPTER;
      if (type == short.class) return SHORT_JSON_ADAPTER;
      if (type == Boolean.class) return BOOLEAN_JSON_ADAPTER.nullSafe();
      if (type == Byte.class) return BYTE_JSON_ADAPTER.nullSafe();
      if (type == Character.class) return CHARACTER_JSON_ADAPTER.nullSafe();
      if (type == Double.class) return DOUBLE_JSON_ADAPTER.nullSafe();
      if (type == Float.class) return FLOAT_JSON_ADAPTER.nullSafe();
      if (type == Integer.class) return INTEGER_JSON_ADAPTER.nullSafe();
      if (type == Long.class) return LONG_JSON_ADAPTER.nullSafe();
      if (type == Short.class) return SHORT_JSON_ADAPTER.nullSafe();
      if (type == String.class) return STRING_JSON_ADAPTER.nullSafe();
```


**After**

```
if (!annotations.isEmpty()) return null;
            if (type == boolean.class) return BOOLEAN_JSON_ADAPTER.nullSafe();
            if (type == byte.class) return BYTE_JSON_ADAPTER.nullSafe();
            if (type == char.class) return CHARACTER_JSON_ADAPTER.nullSafe();
            if (type == double.class) return DOUBLE_JSON_ADAPTER.nullSafe();
            if (type == float.class) return FLOAT_JSON_ADAPTER.nullSafe();
            if (type == int.class) return INTEGER_JSON_ADAPTER.nullSafe();
            if (type == long.class) return LONG_JSON_ADAPTER.nullSafe();
            if (type == short.class) return SHORT_JSON_ADAPTER.nullSafe();
            if (type == Boolean.class) return BOOLEAN_JSON_ADAPTER.nullSafe();
            if (type == Byte.class) return BYTE_JSON_ADAPTER.nullSafe();
            if (type == Character.class) return CHARACTER_JSON_ADAPTER.nullSafe();
            if (type == Double.class) return DOUBLE_JSON_ADAPTER.nullSafe();
            if (type == Float.class) return FLOAT_JSON_ADAPTER.nullSafe();
            if (type == Integer.class) return INTEGER_JSON_ADAPTER.nullSafe();
            if (type == Long.class) return LONG_JSON_ADAPTER.nullSafe();
            if (type == Short.class) return SHORT_JSON_ADAPTER.nullSafe();
            if (type == String.class) return STRING_JSON_ADAPTER.nullSafe();
```



**Now you can use Moshi like this**

```
fun getMoshi(): Moshi {
    return Moshi.Builder()
        .add(MyKotlinJsonAdapterFactory())
        .add(MyStandardJsonAdapters.FACTORY)
        .build()
}
```

**Using retrofit, no problem**

```
Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
        .build()
```


### Links of files are given here

[MyKotlinJsonAdapter](https://github.com/uchhabra3/Moshi-Issue-843-Solution/blob/master/MyKotlinJsonAdapter)

[MyStandardJsonAdapters](https://github.com/uchhabra3/Moshi-Issue-843-Solution/blob/master/MyStandardJsonAdapters)




