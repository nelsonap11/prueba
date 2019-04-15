package tests;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import configuracionbase.BaseFlow;
import stageSet.ComprarStageSet;


@SuiteClasses({ComprarStageSet.class})

public class Comprartest extends BaseFlow{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Comprartest.class);
  
    @BeforeClass
    public static void flag() throws Exception {
        LOGGER.info("Realizar Compra Falabella...");
    }
}