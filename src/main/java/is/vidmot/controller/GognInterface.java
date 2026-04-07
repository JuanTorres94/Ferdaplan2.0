package is.vidmot.controller;

import is.vinnsla.Ferd;

/**
 * Viðmót (interface) fyrir controllera sem þurfa að taka á móti ferðagögnum.
 * Útfært af FerdController til að fá gögn frá ViewSwitcher.
 */
public interface GognInterface {

    /**
     * Setur gögn ferðar í controllerinn.
     *
     * @param ferd ferðin sem á að birta
     */
    void setGogn(Ferd ferd);
}