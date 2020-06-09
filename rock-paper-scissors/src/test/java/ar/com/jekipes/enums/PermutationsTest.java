package ar.com.jekipes.enums;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * mvn -Dtest="ar.com.jekipes.enums.PermutationsTest" test
 * @author juan kipes
 */
public class PermutationsTest {

    @Test
    public void permutations() {
        Permutations result = Permutations.getInstance(Permutations.PAPER_ROCK.name());
        assertThat(result).isEqualTo(Permutations.PAPER_ROCK);
    }
}
