<?php

namespace App\Form;

use App\Entity\Contrat;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\RangeType;

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\Range;
use Symfony\Component\Validator\Constraints\Length;

class ContratType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom', TextType::class, [
                'label_attr' => ['style' => 'margin-right: 98px;'],
                'constraints' => [
                                new NotBlank(['message' => 'Le nom du contrat ne doit pas être vide.']),
                                new Regex(['pattern' => '/^[a-zA-Z\s!@#$%^&*()_+\-=\[\]{};:\'"\\|,.<>\/?]+$/','message' => 'Le nom du contrat ne doit pas contenir des chiffres.']),
                                new Length([
                                    'min' => 2,
                                    'max' => 10,
                                    'minMessage' => 'Le nom du contrat doit être au moins 2 caractères.', 
                                    'maxMessage' => 'Le nom du contrat ne peut pas dépasser 10 caractères.',
                                ]),
                            ],
                        ])      
            ->add('fullname', TextType::class, [
                'label_attr' => ['style' => 'margin-right: 98px;'],
                'constraints' => [
                                new NotBlank(['message' => 'Le nom complet du contrat ne doit pas être vide.']),
                                new Regex(['pattern' => '/^[a-zA-Z\s!@#$%^&*éèà()_+\-=\[\]{};:\'"\\|,.<>\/?]+$/','message' => 'Le nom complet du contrat ne doit pas contenir des chiffres.']),
                                new Length([
                                    'min' => 2,
                                    'max' => 100,
                                    'minMessage' => 'Le nom complet du contrat doit être au moins 2 caractères.', 
                                    'maxMessage' => 'Le nom complet du contrat ne peut pas dépasser 100 caractères.',
                                ]),
                            ],
                        ]) 
            ->add('description', TextareaType::class, [
                'label_attr' => ['style' => 'margin-right: 98px;'],
                'constraints' => [
                                new NotBlank(['message' => 'La description ne doit pas être vide.']),
                                new Length([
                                    'min' => 2,
                                    'max' => 1000,
                                    'minMessage' => 'La description doit être au moins 2 caractères.', 
                                    'maxMessage' => 'La description ne peut pas dépasser 1000 caractères.',
                                ]),
                            ],
                        ]) 
            ->add('submit', SubmitType::class);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Contrat::class,
        ]);
    }
}
