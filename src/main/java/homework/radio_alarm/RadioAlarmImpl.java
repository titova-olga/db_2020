package homework.radio_alarm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RadioAlarmImpl implements RadioAlarm {

    private final Radio radio;
    private final Alarm alarm;

    @Override
    public void c() {
        alarm.c();
    }

    @Override
    public void d() {
        alarm.d();
    }

    @Override
    public void a() {
        radio.a();
    }

    @Override
    public void b() {
        radio.b();
    }
}
