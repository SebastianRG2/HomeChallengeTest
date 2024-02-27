package com.home.challenge.visa.questions

import com.home.challenge.visa.models.Pet
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.that

open class PetCreation : Question<Boolean>{
    companion object {
        fun inStore(): PetCreation {
            return PetCreation()
        }
    }

    @Subject("User validates pet creation successful")
    override fun answeredBy(actor: Actor): Boolean {
       actor.attemptsTo(
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).id).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).id),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).name).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).name),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).category.id).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).category.id),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).category.name).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).category.name),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).photoUrls).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).photoUrls),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).tags).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).tags),
            that(SerenitySession.get<Pet>(GeneralConstants.PET_CREATE_MODEL_KEY).status).isEqualTo(SerenitySession.get<Pet>(GeneralConstants.PET_FIND_MODEL_KEY).status)

       )

        return true
    }
}