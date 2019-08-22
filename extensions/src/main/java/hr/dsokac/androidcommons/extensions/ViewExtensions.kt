package hr.dsokac.androidcommons.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.os.Handler
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.inputmethod.InputMethodManager

/**
 *
 * Extension class for View class
 *
 * @author Danijel Sokač
 */

fun View.showKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    requestFocus()
    inputManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)

    //on some devices keyboard won't show automatically, so we perform touch action
    touch(100)
}

/**
 * Hide keyboard from UI
 */
fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * Performs touch event on current view with delay
 *
 * @param delay     Time in milliseconds to wait before touch event is performed
 */
fun View.touch(delay: Long) {
    Handler().postDelayed({
        dispatchTouchEvent(
            MotionEvent.obtain(
                SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_DOWN, ((right + left) / 2).toFloat(),
                ((top + bottom) / 2).toFloat(), 0
            )
        )

        dispatchTouchEvent(
            MotionEvent.obtain(
                SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_UP, ((right + left) / 2).toFloat(),
                ((top + bottom) / 2).toFloat(), 0
            )
        )
    }, delay)
}

/**
 * Measures height of view
 *
 * @return height of view in pixels
 */
fun View.getHeightOfView(): Int {
    this.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    return this.measuredHeight
}

/**
 * Measures width of view
 *
 * @return width of view in pixels
 */
fun View.getWidthOfView(): Int {
    this.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    return this.measuredWidth
}


//Animations
/**
 * Animates move of view from bottom of the screen to the defined position
 */
fun View.animateBottomIn() {
    // Prepare the View for the animation
    visibility = View.VISIBLE
    alpha = 0.0f

    // Start the animation
    animate()
        .translationY(0.0f)
        .alpha(1.0f)
        .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        .setListener(null)
}

/**
 * Animates move of view from current position to the bottom of the screen and hides the view
 */
fun View.animateBottomOut() {
    animate()
        .translationY(height.toFloat())
        .alpha(0.0f)
        .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                visibility = View.GONE
            }
        })
}

/**
 * Animates moving view from current position to new coordinates
 *
 * @param x     horizontal position to be animated to in pixels
 * @param y     vertical position to be animated to in pixels
 */
fun View.animateMove(x: Float, y: Float) {
    animate()
        .translationX(x)
        .translationY(y)
        .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        .setListener(null)
}

/**
 * Animate movement of view due to margin change.
 * In case that margin is null, current margin value will be used.
 *
 * @param topMargin     New value of top margin
 * @param bottomMargin  New value of bottom margin
 * @param leftMargin    New value of left margin
 * @param rightMargin   New value of right margin
 *
 */
fun ViewGroup.animateMarginChange(topMargin: Int?, bottomMargin: Int?, leftMargin: Int?, rightMargin: Int?) {

    val params = layoutParams as ViewGroup.MarginLayoutParams
    val topMarginStart = params.topMargin
    val bottomMarginStart = params.bottomMargin
    val leftMarginStart = params.leftMargin
    val rightMarginStart = params.rightMargin
    val a = object : Animation() {

        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {

            params.topMargin = interpolatedInt(
                topMarginStart, topMargin
                    ?: params.topMargin, interpolatedTime
            )
            params.bottomMargin = interpolatedInt(
                bottomMarginStart, bottomMargin
                    ?: params.bottomMargin, interpolatedTime
            )
            params.leftMargin = interpolatedInt(
                leftMarginStart, leftMargin
                    ?: params.leftMargin, interpolatedTime
            )
            params.rightMargin = interpolatedInt(
                rightMarginStart, rightMargin
                    ?: params.rightMargin, interpolatedTime
            )

            layoutParams = params
        }

    }
    a.duration = resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
    startAnimation(a)
}

/**
 * Hide view from the user
 *
 * @param shouldAnimate true if hide action should be animated, otherwise false.
 *                      Default is true.
 */
fun View.hide(shouldAnimate: Boolean = true) {
    if (shouldAnimate && visibility == View.VISIBLE) {
        val initialHeight = measuredHeight

        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                if (interpolatedTime == 1f) {
                    visibility = View.GONE
                } else {
                    layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                    requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        a.duration = resources.getInteger(android.R.integer.config_longAnimTime).toLong()
        startAnimation(a)
    } else {
        visibility = View.GONE
    }
}

/**
 * Display view to the user
 *
 * @param shouldAnimate true if show action should apply animation, otherwise false.
 *                      Default is true.
 */
fun View.show(shouldAnimate: Boolean = true) {
    if (shouldAnimate && visibility != View.VISIBLE) {
        measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val targetHeight = measuredHeight

        visibility = View.VISIBLE
        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                layoutParams.height = if (interpolatedTime == 1f)
                    ViewGroup.LayoutParams.WRAP_CONTENT
                else
                    (targetHeight * interpolatedTime).toInt()
                requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        a.duration = resources.getInteger(android.R.integer.config_longAnimTime).toLong()
        startAnimation(a)
    } else {
        visibility = View.VISIBLE
    }
}

/**
 * Interpolates values between start and end according to current time
 *
 * @param start             First value to be used
 * @param end               Target value to be achieved
 * @param interpolatedTime  The value of the normalized time (0.0 to 1.0) after it has been run
 *                          through the interpolation function
 *
 * @return interpolated Int value
 */
private fun interpolatedInt(start: Int, end: Int, interpolatedTime: Float) =
    start + ((end - start) * interpolatedTime).toInt()