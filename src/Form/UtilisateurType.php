<?php

namespace App\Form;

use App\Entity\Utilisateur;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\EmailType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\Email;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;


class UtilisateurType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
        ->add('nom', TextType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ nom ne doit pas être vide.',
                ]),
                new Length([
                    'min' => 2,
                    'max' => 50,
                    'minMessage' => 'Le champ nom doit contenir au moins {{ limit }} caractères.',
                    'maxMessage' => 'Le champ nom doit contenir au maximum {{ limit }} caractères.',
                ]),
            ]
        ])
        ->add('prenom', TextType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ prénom ne doit pas être vide.',
                ]),
                new Length([
                    'min' => 2,
                    'max' => 50,
                    'minMessage' => 'Le champ prénom doit contenir au moins {{ limit }} caractères.',
                    'maxMessage' => 'Le champ prénom doit contenir au maximum {{ limit }} caractères.',
                ]),
            ]
        ])
        ->add('adresse', EmailType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ adresse email ne doit pas Ãªtre vide.',
                ]),
                new Email([
                    'message' => 'L\'adresse email "{{ value }}" n\'est pas valide.',
                ]),
            ]
        ])
        ->add('mdp', PasswordType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Veuillez renseigner votre mot de passe.',
                ]),
                new NotBlank([
                    'message' => 'Le champ mot de passe ne doit pas Ãªtre vide.',
                ]),
                new Length([
                    'min' => 6,
                    'max' => 50,
                    'minMessage' => 'Le champ mot de passe doit contenir au moins {{ limit }} caractÃ¨res.',
                    'maxMessage' => 'Le champ mot de passe doit contenir au maximum {{ limit }} caractÃ¨res.',
                ]),
                new Regex([
                    'pattern' => '/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\w\d\s:])([^\s]){6,16}$/',
                    'message' => 'Le champ mot de passe doit contenir au moins une lettre minuscule, une lettre majuscule, un chiffre et un caractÃ¨re spÃ©cial (par exemple : #, !, %, &).',
                ]),
            ]
        ])

        ->add('role', ChoiceType::class, [
            'choices' => [
                'Admin' => 'ROLE_ADMIN',
                'User' => 'ROLE_USER',
            ],
        ])
        
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Utilisateur::class,
        ]);
    }
}
