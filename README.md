# git clone , commit , push , pull working 

|||||||||||||||||||||||||||||meveo git working |||||||||||||||||||||||||||||||||||||||||||||

cd D:\meveodata\default\git
mkdir customer
cd customer

git init --bare .git
touch .git/git-daemon-export-ok

http://localhost:9090/mygitserver/HelloWorld

git clone http://localhost:9090/mygitserver/git/customer

--------note : port : 9090 ----------------

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
-----------------cartweb2-----------------------


http://localhost:9090/cartweb2/HelloWorld
mkdir   D:\meveodata\default\git
------------------------------------------------

cd D:\meveodata\default\git
mkdir afs
cd afs


git init --bare .git
touch .git/git-daemon-export-ok

git clone http://localhost:9090/cartweb2/git/afs


|||||||||||||||||||||||gitservers|||||||||||||||||||||||||||||||||||||||||||||

default reposity : :          D:\meveodata\default\git
with project module :         D:\meveodata\default\git\afs


git clone http://localhost:9090/gitservers/git/afs
git clone http://localhost:9090/gitservers/git/inventory

|||||||||||||||||||||||||||||||||||||||||||||||


