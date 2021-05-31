# Terminology (adapted from [[1](https://en.wikipedia.org/wiki/Revision_control)])
## Fundamentals

### Change
A change (or diff, or delta) represents a specific modification to a document under version control. The granularity of the modification considered a change varies between version control systems.

### Change list
On many version control systems with atomic multi-change commits, a change list, change set, update, or patch identifies the set of changes made in a single commit. This can also represent a sequential view of the source code, allowing the examination of source "as of" any particular changelist ID.

### Checkout
To check out (or co) is to create a local working copy from the repository. A user may specify a specific revision or obtain the latest. The term 'checkout' can also be used as a noun to describe the working copy.

### Commit
To commit (check in, ci or, more rarely, install, submit or record) is to write or merge the changes made in the working copy back to the repository. The terms 'commit' and 'checkin' can also be used as nouns to describe the new revision that is created as a result of committing.

### Head
Also sometimes called tip, this refers to the most recent commit, either to the trunk or to a branch. The trunk and each branch have their own head.

### Revision
Also version: A version is any change in form. In SVK, a Revision is the state at a point in time.

### Tag
A tag or label refers to an important snapshot in time, consistent across many files. These files at that point may all be tagged with a user-friendly, meaningful name or revision number.

## Detailed terminology

### Master/Trunk/Baseline/Mainline
The unique line of development that is not a branch.

### Branch
A set of files under version control may be branched or forked at a point in time so that, from that time forward, two copies of those files may develop at different speeds or in different ways independently of each other.

### Clone
Cloning means creating a repository containing the revisions from another repository. This is equivalent to pushing or pulling into an empty (newly initialized) repository. As a noun, two repositories can be said to be clones if they are kept synchronized, and contain the same revisions.

### Conflict
A conflict occurs when different parties make changes to the same document, and the system is unable to reconcile the changes. A user must resolve the conflict by combining the changes, or by selecting one change in favor of the other.

### Forward integration
The process of merging changes made in the main trunk into a development (feature or team) branch.

### Initialize
Create a new, empty repository.

### Merge
A merge or integration is an operation in which two sets of changes are applied to a file or set of files. Some sample scenarios are as follows:
*	A user, working on a set of files, updates or syncs their working copy with changes made, and checked into the repository, by other users.
*	A user tries to check in files that have been updated by others since the files were checked out, and the revision control software automatically merges the files (typically, after prompting the user if it should proceed with the automatic merge, and in some cases only doing so if the merge can be clearly and reasonably resolved).
*	A branch is created, the code in the files is independently edited, and the updated branch is later incorporated into a single, unified trunk.
*	A set of files is branched, a problem that existed before the branching is fixed in one branch, and the fix is then merged into the other branch. (This type of selective merge is sometimes known as a cherry pick to distinguish it from the complete merge in the previous case.)

### Promote
The act of copying file content from a less controlled location into a more controlled location. For example, from a user's workspace into a repository, or from a stream to its parent.

### Pull, push
Copy revisions from one repository into another. Pull is initiated by the receiving repository, while push is initiated by the source. Fetch is sometimes used as a synonym for pull.

### Repository (or repo)
The repository is where files' current and historical data are stored can be on server or local machine.  Public repository is one where any developer can see the version history and current state of the repository.  A private repository is one where only that developer (or team) has access to the history and state.

### Resolve
The act of user intervention to address a conflict between different changes to the same document.

### Reverse integration
The process of merging different team branches into the main trunk of the versioning system.

### Working copy
The working copy is the local copy of files from a repository, at a specific time or revision. All work done to the files in a repository is initially done on a working copy, hence the name. Conceptually, it is a sandbox.
