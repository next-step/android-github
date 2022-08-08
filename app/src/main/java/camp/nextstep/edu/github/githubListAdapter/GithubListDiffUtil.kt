package camp.nextstep.edu.github.githubListAdapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import camp.nextstep.edu.github.domain.Github

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
class GithubListDiffUtil : DiffUtil.ItemCallback<Github>() {
    override fun areItemsTheSame(
        oldItem: Github,
        newItem: Github
    ): Boolean {
        return oldItem.fullName == newItem.fullName
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: Github,
        newItem: Github
    ): Boolean {
        return oldItem == newItem
    }
}