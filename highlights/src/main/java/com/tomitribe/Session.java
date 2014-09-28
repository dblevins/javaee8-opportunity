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


    @Slide
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

    @Inject
    public Questions questions;



    /*













    */


    @PreDestroy
    public void thankYou() {

    }


    static {
        Focus.values();
        QuickHistory.values();
        Topics.values();
//        for (final Focus focus : Focus.values()) {
//
//        }
    }
}
