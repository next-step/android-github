package com.nextstep.edu.github.data.entity

import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class RepositoryItem(

	@Json(name="tags_url")
	val tagsUrl: String? = null,

	@Json(name="private")
	val jsonMemberPrivate: Boolean? = null,

	@Json(name="contributors_url")
	val contributorsUrl: String? = null,

	@Json(name="notifications_url")
	val notificationsUrl: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="subscription_url")
	val subscriptionUrl: String? = null,

	@Json(name="keys_url")
	val keysUrl: String? = null,

	@Json(name="branches_url")
	val branchesUrl: String? = null,

	@Json(name="deployments_url")
	val deploymentsUrl: String? = null,

	@Json(name="issue_comment_url")
	val issueCommentUrl: String? = null,

	@Json(name="labels_url")
	val labelsUrl: String? = null,

	@Json(name="subscribers_url")
	val subscribersUrl: String? = null,

	@Json(name="releases_url")
	val releasesUrl: String? = null,

	@Json(name="comments_url")
	val commentsUrl: String? = null,

	@Json(name="stargazers_url")
	val stargazersUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="owner")
	val owner: Owner? = null,

	@Json(name="archive_url")
	val archiveUrl: String? = null,

	@Json(name="commits_url")
	val commitsUrl: String? = null,

	@Json(name="git_refs_url")
	val gitRefsUrl: String? = null,

	@Json(name="forks_url")
	val forksUrl: String? = null,

	@Json(name="compare_url")
	val compareUrl: String? = null,

	@Json(name="statuses_url")
	val statusesUrl: String? = null,

	@Json(name="git_commits_url")
	val gitCommitsUrl: String? = null,

	@Json(name="blobs_url")
	val blobsUrl: String? = null,

	@Json(name="git_tags_url")
	val gitTagsUrl: String? = null,

	@Json(name="merges_url")
	val mergesUrl: String? = null,

	@Json(name="downloads_url")
	val downloadsUrl: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="contents_url")
	val contentsUrl: String? = null,

	@Json(name="milestones_url")
	val milestonesUrl: String? = null,

	@Json(name="teams_url")
	val teamsUrl: String? = null,

	@Json(name="fork")
	val fork: Boolean? = null,

	@Json(name="issues_url")
	val issuesUrl: String? = null,

	@Json(name="full_name")
	val fullName: String? = null,

	@Json(name="events_url")
	val eventsUrl: String? = null,

	@Json(name="issue_events_url")
	val issueEventsUrl: String? = null,

	@Json(name="languages_url")
	val languagesUrl: String? = null,

	@Json(name="html_url")
	val htmlUrl: String? = null,

	@Json(name="collaborators_url")
	val collaboratorsUrl: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="pulls_url")
	val pullsUrl: String? = null,

	@Json(name="hooks_url")
	val hooksUrl: String? = null,

	@Json(name="assignees_url")
	val assigneesUrl: String? = null,

	@Json(name="trees_url")
	val treesUrl: String? = null,

	@Json(name="node_id")
	val nodeId: String? = null
) {

	fun toDto() = RepositoryItemDto(
		fullName = this.fullName ?: "",
		description = this.description ?: ""
	)
}
