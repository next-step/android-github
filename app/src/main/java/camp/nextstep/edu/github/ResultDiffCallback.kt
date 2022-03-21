package camp.nextstep.edu.github

import androidx.recyclerview.widget.DiffUtil
import com.github.dodobest.domain.GithubData

class ResultDiffCallback : DiffUtil.ItemCallback<GithubData>() {
    override fun areItemsTheSame(oldItem: GithubData, newItem: GithubData): Boolean {
        // oldItem == newItem 으로 단축할 수 있지만, data class의 key parameter를 비교한다는
        // 의미를 표현하기 위해 길게 작성했습니다.
        return oldItem.fullName == newItem.fullName && oldItem.description == newItem.description
    }

    override fun areContentsTheSame(oldItem: GithubData, newItem: GithubData): Boolean {
        return oldItem == newItem
    }

}