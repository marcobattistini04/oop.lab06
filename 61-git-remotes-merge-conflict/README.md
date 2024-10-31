# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

- git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git          
   Cloning into 'OOP-git-merge-conflict-test'...
   remote: Enumerating objects: 12, done.
   remote: Counting objects: 100% (4/4), done.
   remote: Compressing objects: 100% (3/3), done.
   remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
   Receiving objects: 100% (12/12), done.
   Resolving deltas: 100% (2/2), done.

2. Ci si assicuri di avere localmente entrambi i branch remoti
- git checkout -b feature 'origin/feature'
   branch 'feature' set up to track 'origin/feature'.
   Switched to a new branch 'feature'
- git branch -v
   feature bed943f Print author information
   master  8e0f29c Change HelloWorld to print the number of available processors

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
- git checkout master
   Switched to branch 'master'
   Your branch is up to date with 'origin/master'.
- git merge feature
   Auto-merging HelloWorld.java
   CONFLICT (content): Merge conflict in HelloWorld.java
   Automatic merge failed; fix conflicts and then commit the result.
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
 
 -> Fixed HelloWorld.java: 
   public final class HelloWorld {

	   private static final String AUTHOR = "Danilo Pianini";

	   public static void main(final String[] args) {

		   System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
		   System.out.println("This program has been realised by " + AUTHOR);
	   }

	   public static int procNumber() {
		   return Runtime.getRuntime().availableProcessors();
	   }
   }
- javac HelloWorld.java
- java HelloWorld.java
   This program is running in a PC with 12 logic processors!
   This program has been realised by Danilo Pianini
- git add HelloWorld.java
- git commit -m 'fixed problem in HelloWorld.java'
   [master 78aebc7] fixed problem in HelloWorld.java

6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
- git remote add personal https://github.com/marcobattistini04/Testing-merge
- git remote -v
   origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
   origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
   personal        https://github.com/marcobattistini04/testing-merge (fetch)
   personal        https://github.com/marcobattistini04/testing-merge (push)
8. Si faccia push del branch `master` sul proprio repository
- git push personal master
   Enumerating objects: 15, done.
   Counting objects: 100% (15/15), done.
   Delta compression using up to 12 threads
   Compressing objects: 100% (11/11), done.
   Writing objects: 100% (15/15), 1.58 KiB | 1.58 MiB/s, done.
   Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
   remote: Resolving deltas: 100% (4/4), done.
   remote: This repository moved. Please use the new location:
   remote:   https://github.com/marcobattistini04/Testing-merge.git
To https://github.com/marcobattistini04/testing-merge
 * [new branch]      master -> master
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
- git branch --set-upstream-to=personal/master
   branch 'master' set up to track 'personal/master'.