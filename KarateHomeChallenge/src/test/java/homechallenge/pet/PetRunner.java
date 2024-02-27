package homechallenge.pet;

import com.intuit.karate.junit5.Karate;

class PetRunner {
    @Karate.Test
    Karate testPet() {
        return Karate.run("pet").relativeTo(getClass());
    }
}
