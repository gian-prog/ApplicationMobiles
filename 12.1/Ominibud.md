## Faille
J'ai découvert une faille SQL dans la requête api/student pour changer notre note ou d'autres informations des autres lorsqu'on est connecté.

## Exploit
1. Se connecter au serveur Omnisus avec la requête api/id/signin avec son compte personnel
![image](https://github.com/user-attachments/assets/a61fb231-7205-4a8e-890d-19f1a790f605)
2. Vérifier votre note avant sur le site `http://10.10.23.10/`.
![image](https://github.com/user-attachments/assets/488b1922-fa6f-4b9e-a217-28f150c235ca)

3. Avec la requête api/student, mettre cette injection SQL dans le body: `Squid Game' WHERE ID = 22; UPDATE MGRADE SET GRADE = 100 WHERE ID = 22; --`.
![image](https://github.com/user-attachments/assets/53ce31b8-353b-43c8-8885-ed12d8e9a193)
4. Vérifier votre note après sur le site `http://10.10.23.10/`.
![image](https://github.com/user-attachments/assets/b901bd87-4e76-4a5f-92f1-90f55311b877)
