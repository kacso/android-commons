package hr.dsokac.androidcommons.test.extensions

import android.os.Build
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import kotlin.reflect.KClass


@Throws(Exception::class)
fun <T : Any> setFinalStaticField(kclass: KClass<T>, fieldName: String, newValue: Any) {
    val field = kclass.java.getField(fieldName)
    field.isAccessible = true

    val modifiersField = Field::class.java.getDeclaredField("modifiers")
    modifiersField.isAccessible = true
    modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())

    field.set(null, newValue)
}

fun setSDK(sdkInt: Int) {
    setFinalStaticField(Build.VERSION::class, "SDK_INT", sdkInt)
}