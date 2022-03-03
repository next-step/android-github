package camp.nextstep.edu.github

import android.widget.TextView
import androidx.databinding.BindingAdapter
import camp.nextstep.edu.github.domain.model.Github

object BindingUtils {
    @JvmStatic
    @BindingAdapter("name")
    fun setAuthorExpression(textView: TextView, github: Github) {
        textView.text = github.fullName
    }

    @JvmStatic
    @BindingAdapter("description")
    fun setDescription(textView: TextView, github: Github) {
        textView.text = github.description
    }
}
