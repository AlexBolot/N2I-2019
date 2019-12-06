# N2I-2019

## Objectifs de l'application

Notre solution a pour objectif de faciliter l'échange entre des personnes en cours de démarche administrative avec des personnes ayant déjà finalisé des démarches similaires.

Notre solution va donc proposer à l'utilsateur des profils ayant complété une démarche similaire (basé sur le type de démarche) et l'utilisateur pourra décider si le niveau de similarité est suffisant ou non.

## Les services

### Profil
Ce service est chargé de la gestion des profils uilisateurs (nom, prénom, mail, age, ville)
Il s'agit principalement d'un service de CRUD (Create, Read, Update, Delete)

### Procédures
Ce service permet de créer de nouvelles procédures pour un profil, d'accéder à toutes les procédures d'un utilisateur, ainsi que l'ensemble des procédures enregistrées par le système.

### Matching
Ce service est le plus important de notre système, il va permettre de sélectionner les procédures similaires à celles d'un utilisateur. Pour l'instant la selection est simplifiée mais elle pourrait être améliorée et développée sans impact sur le reste du système.


## Utilisation de Docker

Nous avons des images pour la partie backend (services et BD) :
- profil:latest (`docker pull mtheos/profil:latest`)
- procedure:latest (`docker pull mtheos/procedure:latest`)
- matching:latest (`docker pull mtheos/matching:latest`)
