package com.github.kacso.androidcommons.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.nio.ByteBuffer

/**
 *
 * Extension class for Bitmap based classes
 *
 * @author Danijel Sokač
 */

/**
 * Convert bitmap to byte array using ByteBuffer.
 *
 * @return image as ByteArray
 */
fun Bitmap.toByteArray(): ByteArray {
    //minimum number of bytes that can be used to store this bitmap's pixels
    val size = this.byteCount

    //allocate new instances which will hold bitmap
    val buffer = ByteBuffer.allocate(size)
    val bytes = ByteArray(size)

    //copy the bitmap's pixels into the specified buffer
    this.copyPixelsToBuffer(buffer)

    //rewinds buffer (buffer position is set to zero and the mark is discarded)
    buffer.rewind()

    //transfer bytes from buffer into the given destination array
    buffer.get(bytes)

    //return bitmap's pixels
    return bytes
}

/**
 * Converts byte array image to Bitmap
 *
 * @return image as Bitmap
 */
fun ByteArray.toBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}