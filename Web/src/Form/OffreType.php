<?php

namespace App\Form;

use App\Entity\Offre;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\CountryType; 
use Symfony\Component\Form\Extension\Core\Type\ChoiceType; 

use Symfony\Bridge\Doctrine\Form\Type\EntityType;

use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\Range;
use Symfony\Component\Validator\Constraints\Length;
class OffreType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
       
            ->add('titre', TextType::class, [
            'label_attr' => ['style' => 'margin-right: 98px;'],
            'constraints' => [
                            new NotBlank(['message' => 'Le titre ne doit pas être vide.']),
                            new Regex(['pattern' => '/^[a-zA-Z\s]+$/','message' => 'Le titre ne doit contenir que des lettres et des espaces.']),
                            new Length([
                                'min' => 2,
                                'max' => 50,
                                'minMessage' => 'Le titre doit être au moins 2 caractères.', 
                                'maxMessage' => 'Le titre ne peut pas dépasser 50 caractères.',
                            ]),
                        ],
                    ])           


            ->add('salaire', NumberType::class, [
            'label_attr' => ['style' => 'margin-right: 82px;'],
            'constraints' => [
                            new NotBlank(['message' => 'Le salaire ne doit pas être vide.']),
                            new Regex([
                                'pattern' => '/^\d+$/',
                                'message' => 'Le salaire ne doit contenir que des chiffres.'
                            ]),
                            new Range([
                                'min' => 459,
                                'max' => 1000000,
                                'minMessage' => 'Le salaire doit être au moins 459.',
                                'maxMessage' => 'Le salaire ne peut pas dépasser 1 000 000.',]),],
            ])

            ->add('description', TextareaType::class, [
                'attr' => ['rows' => 6],
                'label' => 'Description',
                'label_attr' => ['style' => 'margin-right: 10px;'],
                'constraints' => [
                    new NotBlank([
                        'message' => 'La description ne doit pas être vide.'
                    ]),
                    new Length([
                        'min' => 2,
                        'max' => 500,
                        'minMessage' => 'La description doit être au moins 2 caractères.', 
                        'maxMessage' => 'La description ne peut pas dépasser 500 caractères.',
                    ]),
                ],
            ])                
            ->add('lieu', CountryType::class, ['label_attr' => ['style' => 'margin-right: 100px;'],])
            ->add('contrat')
          //  ->add('domaine')
          ->add('domaine')



       //     ->add('candidatures')
     /*       ->add('titre')
            ->add('description')
            ->add('salaire')
            ->add('duree')
            ->add('lieu')
            ->add('status')*/

// ['attr' => ['disabled' => false, 'placeholder' => 'Disponible'],])

       //     ->add('description', TextareaType::class, ['attr' => ['rows' => 6],'label' => 'Description','label_attr' => ['style' => 'margin-right: 10px;'],])
// ->add('duree', NumberType::class, ['label' => 'Durée en mois','label_attr' => ['style' => 'margin-right: 10px;'],])

->add('status', ChoiceType::class, [
    'choices' => [
        'Disponible' => 'Disponible',
        'Non disponible' => 'Non disponible',
    ],
    'expanded' => false,
    'multiple' => false,
 
    'required' => true,
    'data' => 'Disponible', // This sets the default value to 'option2'
    ]   , TextType::class, ['attr' => ['disabled' => false, 'placeholder' => 'Disponible' 
    ]])
            //->add('post')


            ->add('submit', SubmitType::class);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Offre::class,
        ]);
    }
}
