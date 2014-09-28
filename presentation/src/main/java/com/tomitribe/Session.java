package com.tomitribe;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

@Title("Java EE Game Changers")
public class Session {

    @dblevins("David Blevins")
    String presenter;


    /*













     */


    @PostConstruct
    public void disclaimer() {
        throw new TopicTooLargeException();
    }



    /*













    */


    /**
     * Not going to read you the specs
     */
    @Slide("Technical and Industry")
    public static enum Focus {
        NON_OBVIOUS,

        BACKSTORY,

        VICTORIES,

        POSSIBILITIES,

        INVOLVEMENT
    }


    /*













     */


    @Slide
    @Note("Still too many")
    public static enum Topics {
        /* Past */
        QUICK_HISTORY,

        /* Present */
        EMBEDDED_CONTAINERS,

        CDI,

        DATA,

        JCP,

        TESTING,

        /* Future */
        JMS_MDB,

        META_ANNOTATIONS,

        LAMBDAS,

        SECURITY,

    }




    /*













    */


    @Slide("Leaving J2EE Behind")
    public static enum QuickHistory {
        /** Thank you, XDoclet **/
        ANNOTATIONS,

        /** Simplify packaging **/
        EARS_GONE,

        /** Only what is needed **/
        WEB_PROFILE,

        /** 'Trim' Legacy **/
        FULL_PROFILE,
    }



    /*













    */


    @Slide("The JCP is Yours")
    public static enum JCP {
        @Year(2004)
        CERTIFIED_OPEN_SOURCE_SERVERS,

        @Year(2009)
        JSR_OPEN_SOURCE_TCK,

        @Year(2013)
        OPENLY_DEVELOPED_JAVAEE_RELEASE,

        @Year(2017)
        UNKNOWN, /** You decide **/
    }




    /*













    */

    @Inject
    public Questions questions;



    /*













    */


    @PreDestroy
    public void thankYou() {

    }


    static {
        Focus.values();
        JCP.values();
        QuickHistory.values();
        Topics.values();
//        for (final Focus focus : Focus.values()) {
//
//        }
    }
}
