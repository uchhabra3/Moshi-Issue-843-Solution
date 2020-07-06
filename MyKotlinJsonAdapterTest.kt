

import org.junit.Test

class MyKotlinJsonAdapterTest {

    data class User(var x: Int = 10, var y: String = "Test")

    // null from API, default value also null, nullable prop
    data class Test01(var bar: Boolean? = null)
    data class Test02(var bar: Byte? = null)
    data class Test03(var bar: Char? = null)
    data class Test04(var bar: Double? = null)
    data class Test05(var bar: Float? = null)
    data class Test06(var bar: Int? = null)
    data class Test07(var bar: Long? = null)
    data class Test08(var bar: Short? = null)
    data class Test09(var bar: String? = null)
    data class Test0A(var bar: User? = null)


    // null from API, default value present, nullable prop
    data class Test11(var bar: Boolean? = false)
    data class Test12(var bar: Byte? = 0)
    data class Test13(var bar: Char? = 'a')
    data class Test14(var bar: Double? = 1.23)
    data class Test15(var bar: Float? = 1.2f)
    data class Test16(var bar: Int? = 12)
    data class Test17(var bar: Long? = 12L)
    data class Test18(var bar: Short? = 1)
    data class Test19(var bar: String? = "Test")
    data class Test1A(var bar: User? = User())

    // non-null from API, default value present, non nullable prop
    // Test11_1 to Test1A_1

    // null from API, default value present, non nullable prop
    data class Test21(var bar: Boolean = false)
    data class Test22(var bar: Byte = 0)
    data class Test23(var bar: Char = 'a')
    data class Test24(var bar: Double = 1.23)
    data class Test25(var bar: Float = 1.2f)
    data class Test26(var bar: Int = 12)
    data class Test27(var bar: Long = 12L)
    data class Test28(var bar: Short = 1)
    data class Test29(var bar: String = "Test")
    data class Test2A(var bar: User = User())

    // non-null from API, default value present, non nullable prop
    // Test21_1 to Test2A_1


    // conversion cases
    data class Test31(var bar: Byte = 0)
    data class Test32(var bar: Double = 1.23)
    data class Test33(var bar: Float = 1.2f)
    data class Test34(var bar: Int = 12)
    data class Test35(var bar: Long = 12L)
    data class Test36(var bar: Short = 1)

    // number to string
    data class Test37(var bar: String = "XYZ")

    @Test
    fun `null as default value 01`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test01::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 02`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test02::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 03`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test03::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 04`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test04::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 05`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test05::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 06`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test06::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 07`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test07::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 08`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test08::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 09`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test09::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }

    @Test
    fun `null as default value 0A`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test0A::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == null)
    }


    @Test
    fun `null as default value 11`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test11::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == false)
    }

    @Test
    fun `null as default value 12`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test12::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 0.toByte())
    }

    @Test
    fun `null as default value 13`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test13::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 'a')
    }

    @Test
    fun `null as default value 14`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test14::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.23)
    }

    @Test
    fun `null as default value 15`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test15::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.2f)
    }

    @Test
    fun `null as default value 16`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test16::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 12)
    }

    @Test
    fun `null as default value 17`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test17::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 12L)
    }

    @Test
    fun `null as default value 18`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test18::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.toShort())
    }

    @Test
    fun `null as default value 19`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test19::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "Test")
    }

    @Test
    fun `null as default value 1A`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test1A::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar?.x == User().x && instance.bar?.y == User().y)
    }


    @Test
    fun `null as default value 11_1`() {
        val json = """{"bar": true}"""
        val adapter = getMoshi()
            .adapter(Test11::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == true)
    }

    @Test
    fun `null as default value 12_1`() {
        val json = """{"bar": 3}"""
        val adapter = getMoshi()
            .adapter(Test12::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 3.toByte())
    }

    @Test
    fun `null as default value 13_1`() {
        val json = """{"bar": "z"}"""
        val adapter = getMoshi()
            .adapter(Test13::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 'z')
    }

    @Test
    fun `null as default value 14_1`() {
        val json = """{"bar": 1.2999}"""
        val adapter = getMoshi()
            .adapter(Test14::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.2999)
    }

    @Test
    fun `null as default value 15_1`() {
        val json = """{"bar": 1.090}"""
        val adapter = getMoshi()
            .adapter(Test15::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.090f)
    }

    @Test
    fun `null as default value 16_1`() {
        val json = """{"bar": 123}"""
        val adapter = getMoshi()
            .adapter(Test16::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 123)
    }

    @Test
    fun `null as default value 17_1`() {
        val json = """{"bar": 22}"""
        val adapter = getMoshi()
            .adapter(Test17::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 22L)
    }

    @Test
    fun `null as default value 18_1`() {
        val json = """{"bar": 2}"""
        val adapter = getMoshi()
            .adapter(Test18::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 2.toShort())
    }

    @Test
    fun `null as default value 19_1`() {
        val json = """{"bar": "XYZ"}"""
        val adapter = getMoshi()
            .adapter(Test19::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "XYZ")
    }

    @Test
    fun `null as default value 1A_1`() {
        val json = """{"bar": {"x": 1234, "y" : "TestingTest"}}"""
        val adapter = getMoshi()
            .adapter(Test1A::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar?.x == 1234 && instance.bar?.y == "TestingTest")
    }

    @Test
    fun `null as default value 21`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test21::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == false)
    }

    @Test
    fun `null as default value 22`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test22::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 0.toByte())
    }

    @Test
    fun `null as default value 23`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test23::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 'a')
    }

    @Test
    fun `null as default value 24`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test24::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.23)
    }

    @Test
    fun `null as default value 25`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test25::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.2f)
    }

    @Test
    fun `null as default value 26`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test26::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 12)
    }

    @Test
    fun `null as default value 27`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test27::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 12L)
    }

    @Test
    fun `null as default value 28`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test28::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.toShort())
    }

    @Test
    fun `null as default value 29`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test29::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "Test")
    }

    @Test
    fun `null as default value 2A`() {
        val json = """{"bar": null}"""
        val adapter = getMoshi()
            .adapter(Test2A::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar.x == User().x && instance.bar.y == User().y)
    }

    @Test
    fun `null as default value 21_1`() {
        val json = """{"bar": true}"""
        val adapter = getMoshi()
            .adapter(Test21::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == true)
    }

    @Test
    fun `null as default value 22_1`() {
        val json = """{"bar": 3}"""
        val adapter = getMoshi()
            .adapter(Test22::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 3.toByte())
    }

    @Test
    fun `null as default value 23_1`() {
        val json = """{"bar": "z"}"""
        val adapter = getMoshi()
            .adapter(Test23::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 'z')
    }

    @Test
    fun `null as default value 24_1`() {
        val json = """{"bar": 1.2999}"""
        val adapter = getMoshi()
            .adapter(Test24::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.2999)
    }

    @Test
    fun `null as default value 25_1`() {
        val json = """{"bar": 1.090}"""
        val adapter = getMoshi()
            .adapter(Test25::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.090f)
    }

    @Test
    fun `null as default value 26_1`() {
        val json = """{"bar": 123}"""
        val adapter = getMoshi()
            .adapter(Test26::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 123)
    }

    @Test
    fun `null as default value 27_1`() {
        val json = """{"bar": 22}"""
        val adapter = getMoshi()
            .adapter(Test27::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 22L)
    }

    @Test
    fun `null as default value 28_1`() {
        val json = """{"bar": 2}"""
        val adapter = getMoshi()
            .adapter(Test28::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 2.toShort())
    }

    @Test
    fun `null as default value 29_1`() {
        val json = """{"bar": "XYZ"}"""
        val adapter = getMoshi()
            .adapter(Test29::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "XYZ")
    }

    @Test
    fun `null as default value 2A_1`() {
        val json = """{"bar": {"x": 1234, "y" : "TestingTest"}}"""
        val adapter = getMoshi()
            .adapter(Test2A::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar.x == 1234 && instance.bar.y == "TestingTest")
    }

    @Test
    fun `String to Byte`() {
        val json = """{"bar": "-45"}"""
        val adapter = getMoshi()
            .adapter(Test31::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == (-45).toByte())
    }

    @Test
    fun `String to Double`() {
        val json = """{"bar": "1.23"}"""
        val adapter = getMoshi()
            .adapter(Test32::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.23)
    }

    @Test
    fun `String to Float`() {
        val json = """{"bar": "1.23"}"""
        val adapter = getMoshi()
            .adapter(Test33::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1.23f)
    }

    @Test
    fun `String to Int`() {
        val json = """{"bar": "199"}"""
        val adapter = getMoshi()
            .adapter(Test34::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 199)
    }


    @Test
    fun `String to Long`() {
        val json = """{"bar": "1583674200000"}"""
        val adapter = getMoshi()
            .adapter(Test35::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 1583674200000)
    }

    @Test
    fun `String to Short`() {
        val json = """{"bar": "124"}"""
        val adapter = getMoshi()
            .adapter(Test36::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == 124.toShort())
    }

    @Test
    fun `Int to String`() {
        val json = """{"bar": 124}"""
        val adapter = getMoshi()
            .adapter(Test37::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "124")
    }

    @Test
    fun `Long to String`() {
        val json = """{"bar": 1583674200000}"""
        val adapter = getMoshi()
            .adapter(Test37::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "1583674200000")
    }

    @Test
    fun `Double to String`() {
        val json = """{"bar": 1583674.345}"""
        val adapter = getMoshi()
            .adapter(Test37::class.java)
        val instance = adapter.fromJson(json)!!
        check(instance.bar == "1583674.345")
    }

}
