<?php

namespace App\Form;

use App\Entity\Profil;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\Email;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Form\Extension\Core\Type\TextType;

class ProfilType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
        ->add('Nom', TextType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ Nom ne doit pas être vide.',
                ]),
            ],
        ])
        ->add('Prenom', TextType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ Prénom ne doit pas être vide.',
                ]),
            ],
        ])
            ->add('NumeroTelephone', TextType::class, [
                'constraints' => [
                    new Regex([
                        'pattern' => '/^[0-9]+$/',
                        'message' => 'Le numéro de téléphone doit être un entier.',
                    ]),
                ],
            ])
        
            ->add('Email', TextType::class, [
                'constraints' => [
                    new Email([
                        'message' => 'L\'adresse email "{{ value }}" n\'est pas valide.',
                    ]),
                ],
            ])

            ->add('Localisation',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Localisation ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('Description', TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Description ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('Langues',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Langues ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('Competences',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Competences ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('Formation', TextType::class,[
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Formation ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('ExperiencesProfessionnelles', TextType::class,[
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ ExperiencesProfessionnelles ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('latitude',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ latitude ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('longitude',TextType::class,[
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ longitude ne doit pas être vide.',
                    ]),
                ],
            ])
            ->add('Diplome',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ Diplome ne doit pas être vide.',
                    ]),
                ],
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Profil::class,
        ]);
    }
}
