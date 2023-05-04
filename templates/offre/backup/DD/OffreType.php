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
class OffreType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
       
            ->add('titre', TextType::class, ['label_attr' => ['style' => 'margin-right: 98px;'],])
            ->add('salaire', NumberType::class, ['label_attr' => ['style' => 'margin-right: 82px;'],])
            ->add('lieu', CountryType::class, ['label_attr' => ['style' => 'margin-right: 100px;'],])
            ->add('contrat')
          //  ->add('domaine')
          ->add('domaine')

            ->add('recruteur')


       //     ->add('candidatures')
     /*       ->add('titre')
            ->add('description')
            ->add('salaire')
            ->add('duree')
            ->add('lieu')
            ->add('status')*/

            ->add('description', TextareaType::class, ['attr' => ['rows' => 6],'label' => 'Description','label_attr' => ['style' => 'margin-right: 10px;'],])
// ->add('duree', NumberType::class, ['label' => 'Durée en mois','label_attr' => ['style' => 'margin-right: 10px;'],])

            ->add('status', ChoiceType::class, [
                'choices' => [
                    'Disponible' => 'Disponible',
                    'Non disponible' => 'Non disponible',
                ],
                'expanded' => true,
                'multiple' => false,
                'placeholder' => 'Choisir une option',
                'required' => true,
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
