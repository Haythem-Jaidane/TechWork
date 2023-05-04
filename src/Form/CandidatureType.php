<?php

namespace App\Form;

use App\Entity\Candidature;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType; 

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\Range;
use Symfony\Component\Validator\Constraints\Length;
class CandidatureType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
        ->add('candidat')
            ->add('offre')

            ->add('status', ChoiceType::class, [
                'choices' => [
                    'Acceptée' => 'Acceptée',
                    'Rejetée' => 'Rejetée',
                ],
                'expanded' => false,
                'multiple' => false,
             
                'required' => true, 
                ]   , TextType::class, ['attr' => ['disabled' => false, 'placeholder' => 'Disponible' 
                ]])
            ->add('details', TextareaType::class, [
                'label_attr' => ['style' => 'margin-right: 98px;'],
                'constraints' => [
                                new Length([
                                    'min' => 2,
                                    'max' => 1000,
                                    'minMessage' => 'La raison de confirmation ou de rejet doit être au moins 2 caractères.', 
                                    'maxMessage' => 'La raison de confirmation ou de rejet ne peut pas dépasser 1000 caractères.',
                                ]),
                            ],
                        ]) 

                      
            ->add('submit', SubmitType::class);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Candidature::class,
        ]);
    }
}
