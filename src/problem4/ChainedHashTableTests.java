package problem4;

import utils.SimpleMapTests;

import org.junit.jupiter.api.BeforeEach;

/**
 * Tests of chained hash tables.
 */
public class ChainedHashTableTests extends SimpleMapTests {
  /**
   * Prepare for each test.
   */
  @BeforeEach
  public void setupChainedHashTableTests() {
    stringMap = new ChainedHashTable<String,String>();
  } // setupChainedHashTableTests()
} // class ChainedHashTableTests
