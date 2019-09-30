package i.d.leanback_sample.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getColorRes(@ColorRes id: Int) =
	ContextCompat.getColor(this, id)

fun Context.getDrawableRes(@DrawableRes id: Int) =
	ContextCompat.getDrawable(this, id)

fun Context.getDimensionPixelSizeRes(@DimenRes id: Int) =
	this.resources.getDimensionPixelSize(id)

fun Context.getDimensionRes(@DimenRes id: Int) =
	this.resources.getDimension(id)