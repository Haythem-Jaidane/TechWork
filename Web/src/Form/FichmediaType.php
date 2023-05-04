<?php

namespace App\Form;
use App\Entity\Projet;
use App\Entity\Fichmedia;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
class FichmediaType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nommedia',TextType::class,[
                "label"=>'Nom Fichier Media :',
            ])
            ->add('urlmedia',TextType::class,[
                "label"=>'URL Fichier Media :',
            ])
            ->add('typemedia',TextType::class,[
                "label"=>'Type Fichier Media :',
            ])
            ->add('id',EntityType::class,[
                'class'=>Projet::class,
                "choice_label"=>'nom',
                "label"=>'Nom Projet :',
                'expanded'=>false,
                'multiple'=>false] 
               
                )
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Fichmedia::class,
        ]);
    }
}
