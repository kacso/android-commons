package hr.dsokac.androidcommons.extensions

/**
 *
 * Extension class for Double class
 *
 * @author Danijel Sokač
 */

/**
 * Format double value to string with predefined number of decimal digits displayed
 *
 * @param digits    number of decimal digits to display
 *
 * @return String formatted Double value
 */
fun Double.format(digits: Int): String = String.format("%.${digits}f", this)
