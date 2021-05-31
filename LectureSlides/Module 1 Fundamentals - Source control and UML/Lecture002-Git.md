# CS 417/505 Design patterns
# Version control and Git

## Why version control

aka Revision or source control

-   Backup/restore

-   Change tracking – audit/issue investigation

-   Synchronization

-   Control workflow to improve stability

## Fundamentals part 1

### Basic view

-   Fundamental workflow
  - checkout
  - commit (or revert)

-   Snapshot of changes over time – Commits

-   Directed commit graph

### Terminology (See definitions [here](https://github.com/CCSU-CS407F15/CourseInfo/blob/master/GitTerminology.md) )

-   Head

-   Change

-   Change list

-   Revision

-   Tag

-   Checkout

-   Commit

### DVCS vs. CVCS

-   Atomic operations

-   File locking

-   Merging

-   Examples

    -   **CVCS** – SVN, CVS, Perforce, VSS, SCSS, RCS

    -   **DVCS –** Git, Mercurial, DCVS

## Fundamentals part 2 - Merge

Common scenarios

1.  No other changes

2.  Other changes no relation

3.  Other changes with relation

4.  Direct file conflict

## The Git system overview

### General characteristics

-   DVCS architecture – straight forward migration from SVN

-   Branch based design

-   Developer friendly

-   Structured workflow friendly

-   Result: quick uptake by both individual developers and industry

### The architecture and terminology

-   Repositories aka repos (public/private)

-   Server vs local (working copy)

-   Clone

-   Pull/Push

-   Branch

### Git setup

-   Refer to [Install & config guide](https://gist.github.com/dmangiarelli/1a0ae107aaa5c478c51e)

### Basic operations

Create repo

> git init

Help

>git help *command* (ex. git help add)

Current status

> git status

History

> git log
>
> git log --oneline

#### Workflow essence

Create/modify files in some way
Stage files, can stage some or all

> git add readme.txt

To remove a file from staging (but keep file)

> git rm readme.txt

Commit staged changes

> git commit

### Good commit messages critical
Below extract from Chris Beams good explanation [http://chris.beams.io/posts/git-commit/](http://chris.beams.io/posts/git-commit/)

-   Separate subject from body with a blank line
-   Limit the subject line to 50 characters
-   Capitalize the subject line
-   Do not end the subject line with a period
-   Use the imperative mood in the subject line
-   Wrap the body at 72 characters

### Git remote integration

If initialized repository locally and want to push…

>git remote add origin https://github.com/**username**/sandbox.git
>git push -u origin master

If retrieving remote repository for first time

>git clone https://github.com/**username**/sandbox.git

Then you can use
> git push
>
> git pull

### Tools

Command line invocation GUI tools if you used setup guide

-   > git mergetool

-   > git difftool

GUI git tools

-   GitHub Desktop (<https://desktop.github.com/>)

-   **SourceTree** by Atlassian

    This is by far the best in my opinion as 90% of what you typically do can be done through an intuitive GUI

## Git workflows

exceptional tutorial by Atlassian [https://www.atlassian.com/git/tutorials/comparing-workflows/](https://www.atlassian.com/git/tutorials/comparing-workflows/) material below is extracted from there


### Centralized flow

<img src="https://wac-cdn.atlassian.com/dam/jcr:f03a0fbd-a880-477f-aa32-33340383ce07/02%20(3).svg?cdnVersion=jw" alt="Centralized merge" style="width: 400px;"/><br/>
Credit https://www.atlassian.com/git/tutorials/comparing-workflows/

Basic commands:
> git clone ssh://user@host/path/to/repo.git

>git status \# View the state of the repo

>git add \<some-file\> \# Stage a file

>git commit \# Commit a file\</some-file\>

>git push origin master

If merge needed

>git pull --rebase origin master

>git add \<some-file\>

>git rebase –continue

>git push origin master

### Feature branch workflow

<img src="https://wac-cdn.atlassian.com/dam/jcr:223f5106-2191-4450-8916-e5c80d7d907a/02.svg" alt="Feature branch overview" style="width: 400px;"/><br/>
Credit https://www.atlassian.com/git/tutorials/comparing-workflows/

<img src="https://wac-cdn.atlassian.com/dam/jcr:09308632-38a3-4637-bba2-af2110629d56/07.svg" alt="Feature branch merge" style="width: 400px;"/><br/>
Credit https://www.atlassian.com/git/tutorials/comparing-workflows/

Basic commands
>git checkout -b marys-feature master

>git status

>git add \<some-file\>

>git commit

>git push -u origin marys-feature

>git push

When finished with feature
>// Create pull request

After discussion
>git checkout master

>git pull

>git pull origin marys-feature

>git push

### GitFlow workflow

<img src="https://www.atlassian.com/dam/jcr:a9cea7b7-23c3-41a7-a4e0-affa053d9ea7/04%20(1).svg" alt="GitFlow branching overview" style="width: 600px;"/><br/>
Credit https://www.atlassian.com/git/tutorials/comparing-workflows/

>git branch develop

>git push -u origin develop

#### Feature development

>git checkout -b some-feature develop

>git status

>git add \<some-file\>

>git commit

>git pull origin develop

>git checkout develop

>git merge some-feature

>// Create pull request

After some discussion
>git push

>git branch -d some-feature

#### Release flow

>git checkout -b release-0.1 develop

>git checkout master

>git merge release-0.1

>git push

>git checkout develop

>git merge release-0.1

>git push

>git branch -d release-0.1

>git tag -a 0.1 -m "Initial public release" master

>git push –tags

#### Bug flow

>git checkout -b issue-\#001 master

Fix the bug

>git checkout master

>git merge issue-\#001

>git push

>git checkout develop

>git merge issue-\#001

>git push

>git branch -d issue-\#001

### Forking workflow

<img src="https://wac-cdn.atlassian.com/dam/jcr:642c56e3-ddc6-43ff-ab86-c5cd845afd05/03.svg?cdnVersion=jw" alt="Forking flow overview" style="width: 400px;"/><br/>
Credit https://www.atlassian.com/git/tutorials/comparing-workflows/

***Test you skills and use this flow to help improve this repository!!!***

Problems – draw branch diagram
==============================

-   Given a commit/branch tree

    -   Identify workflow used

    -   Describe what is happening

-   Given development scenario draw tree for a specific workflow
