package com.mobile.tandil.javabaseproject.listener;

import java.io.Serializable;
import java.util.Calendar;

public interface ListenerPickers extends Serializable {
    void listenStartingDate(Calendar date);
    void listenEndingDate(Calendar date);
}
