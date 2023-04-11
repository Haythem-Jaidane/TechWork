<?php

namespace App\Form;
use App\Entity\Projet;
use App\Entity\Fichmedia;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
class FichmediaType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nommedia')
            ->add('urlmedia')
            ->add('typemedia')
            ->add('id',EntityType::class,[
                'class'=>Projet::class,
                "choice_label"=>'nom',
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
