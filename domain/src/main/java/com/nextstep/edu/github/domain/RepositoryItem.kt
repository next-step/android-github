package com.nextstep.edu.github.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoryItem(

	@Transient
	@Json(name="tags_url")
	val tagsUrl: String? = null,

	@Transient
	@Json(name="private")
	val jsonMemberPrivate: Boolean? = null,

	@Transient
	@Json(name="contributors_url")
	val contributorsUrl: String? = null,

	@Transient
	@Json(name="notifications_url")
	val notificationsUrl: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Transient
	@Json(name="subscription_url")
	val subscriptionUrl: String? = null,

	@Transient
	@Json(name="keys_url")
	val keysUrl: String? = null,

	@Transient
	@Json(name="branches_url")
	val branchesUrl: String? = null,

	@Transient
	@Json(name="deployments_url")
	val deploymentsUrl: String? = null,

	@Transient
	@Json(name="issue_comment_url")
	val issueCommentUrl: String? = null,

	@Transient
	@Json(name="labels_url")
	val labelsUrl: String? = null,

	@Transient
	@Json(name="subscribers_url")
	val subscribersUrl: String? = null,

	@Transient
	@Json(name="releases_url")
	val releasesUrl: String? = null,

	@Transient
	@Json(name="comments_url")
	val commentsUrl: String? = null,

	@Transient
	@Json(name="stargazers_url")
	val stargazersUrl: String? = null,

	@Transient
	@Json(name="id")
	val id: Int? = null,

	@Transient
	@Json(name="owner")
	val owner: Owner? = null,

	@Transient
	@Json(name="archive_url")
	val archiveUrl: String? = null,

	@Transient
	@Json(name="commits_url")
	val commitsUrl: String? = null,

	@Transient
	@Json(name="git_refs_url")
	val gitRefsUrl: String? = null,

	@Transient
	@Json(name="forks_url")
	val forksUrl: String? = null,

	@Transient
	@Json(name="compare_url")
	val compareUrl: String? = null,

	@Transient
	@Json(name="statuses_url")
	val statusesUrl: String? = null,

	@Transient
	@Json(name="git_commits_url")
	val gitCommitsUrl: String? = null,

	@Transient
	@Json(name="blobs_url")
	val blobsUrl: String? = null,

	@Transient
	@Json(name="git_tags_url")
	val gitTagsUrl: String? = null,

	@Transient
	@Json(name="merges_url")
	val mergesUrl: String? = null,

	@Transient
	@Json(name="downloads_url")
	val downloadsUrl: String? = null,

	@Transient
	@Json(name="url")
	val url: String? = null,

	@Transient
	@Json(name="contents_url")
	val contentsUrl: String? = null,

	@Transient
	@Json(name="milestones_url")
	val milestonesUrl: String? = null,

	@Transient
	@Json(name="teams_url")
	val teamsUrl: String? = null,

	@Transient
	@Json(name="fork")
	val fork: Boolean? = null,

	@Transient
	@Json(name="issues_url")
	val issuesUrl: String? = null,

	@Json(name="full_name")
	val fullName: String? = null,

	@Transient
	@Json(name="events_url")
	val eventsUrl: String? = null,

	@Transient
	@Json(name="issue_events_url")
	val issueEventsUrl: String? = null,

	@Transient
	@Json(name="languages_url")
	val languagesUrl: String? = null,

	@Transient
	@Json(name="html_url")
	val htmlUrl: String? = null,

	@Transient
	@Json(name="collaborators_url")
	val collaboratorsUrl: String? = null,

	@Transient
	@Json(name="name")
	val name: String? = null,

	@Transient
	@Json(name="pulls_url")
	val pullsUrl: String? = null,

	@Transient
	@Json(name="hooks_url")
	val hooksUrl: String? = null,

	@Transient
	@Json(name="assignees_url")
	val assigneesUrl: String? = null,

	@Transient
	@Json(name="trees_url")
	val treesUrl: String? = null,

	@Transient
	@Json(name="node_id")
	val nodeId: String? = null
)
