package i.d.leanback_sample.cards.leanback

import android.graphics.drawable.Drawable
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

class ImageCardViewTarget(view: ImageCardView) : CustomViewTarget<ImageCardView, Drawable>(view) {
	override fun onLoadFailed(errorDrawable: Drawable?) {
		view.mainImage = errorDrawable
	}

	override fun onResourceCleared(placeholder: Drawable?) {
		view.mainImage = placeholder
	}

	override fun onResourceReady(
		resource: Drawable,
		transition: Transition<in Drawable>?
	) {
		view.mainImage = resource
	}
}