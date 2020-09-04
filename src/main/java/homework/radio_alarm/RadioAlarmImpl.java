package homework.radio_alarm;

import lombok.AllArgsConstructor;

public class RadioAlarmImpl implements RadioAlarm {

    private Radio radio = new DefaultRadioImpl();
    private Alarm alarm = new DefaultAlarmImpl();

    public RadioAlarmImpl() {

    }

    public RadioAlarmImpl(Radio radio, Alarm alarm) {
        this.radio = radio;
        this.alarm = alarm;
    }

    public RadioAlarmImpl(Alarm alarm) {
        this.alarm = alarm;
    }

    public RadioAlarmImpl(Radio radio) {
        this.radio = radio;
    }

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
