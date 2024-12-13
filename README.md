# Projet Citronix

## Description
Citronix est une application de gestion pour une ferme de citrons, permettant aux fermiers de suivre la production, la récolte, et la vente de leurs produits. L'application facilite la gestion des fermes, champs, arbres, récoltes, et ventes, tout en optimisant le suivi de la productivité des arbres en fonction de leur âge.

## Fonctionnalités principales
- Gestion des Fermes
- Gestion des Champs
- Gestion des Arbres
- Gestion des Récoltes
- Détails des Récoltes
- Gestion des Ventes

## Technologies utilisées
- Spring Boot
- JPA/Hibernate
- JUnit et Mockito
- Lombok
- MapStruct

## Architecture
L'application suit une architecture en couches :
- Controller
- Service
- Repository
- Entity

## Contraintes métier
- Superficies minimales et maximales des champs
- Nombre maximum de champs par ferme
- Espacement entre les arbres
- Durée de vie maximale des arbres
- Période de plantation
- Limites saisonnières pour les récoltes

