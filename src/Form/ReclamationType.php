<?php

namespace App\Form;

use App\Entity\Reclamation;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\NotBlank;

class ReclamationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            
        ->add('objet', null, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ objet ne peut pas être vide',
                ]),
            ],
        ])
        ->add('msg', null, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ message ne peut pas être vide',
                ]),
            ],
        ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Reclamation::class,
        ]);
    }
}
