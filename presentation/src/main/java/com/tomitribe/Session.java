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

        LAMBDAS

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


    @Slide("EJB.last")
    public static enum DeprecatingEJB {

        BIGGER_OPPORTUNITY,

        REDO_USING_LAMDAS,

        KILL_DONT_COPY
    }




    /*













    */


    @Slide
    public static enum OurFuture {

        WE_GET_OUT_WHAT_WE_PUT_IN,

        /** Portability is not a silver bullet, it's a life raft **/
        PORTABILITY,

        ITS_OUR_GAME,

        NEXT_10_ARE_UP_TO_US,

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



    /*













    */


    static {
        Focus.values();
        JCP.values();
        QuickHistory.values();
        Topics.values();
        DeprecatingEJB.values();
        OurFuture.values();
//        for (final Focus focus : Focus.values()) {
//
//        }
    }
}
