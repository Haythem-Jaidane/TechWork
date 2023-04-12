<?php

namespace App\Form;

use App\Entity\Publication;
use App\Entity\Profil;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\NotBlank;

class PublicationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
        ->add('objet',TextType::class, [
            'constraints' => [
                new NotBlank([
                    'message' => 'Le champ Objet ne doit pas être vide.',
                ]),
            ],
        ])
            ->add('message',TextType::class, [
                'constraints' => [
                    new NotBlank([
                        'message' => 'Le champ message ne doit pas être vide.',
                    ]),
                ],
            ])
            //->add('idCours') BECH RODHA NULL FIL BD
            ->add('id_Profil',EntityType::class,[
                'class'=>Profil::class,
                "choice_label"=>'Prenom',
                'expanded'=>false,
                'multiple'=>false
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Publication::class,
        ]);
    }
}
