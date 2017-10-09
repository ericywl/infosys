package Part_C.piano;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;

import Part_C.midi.Instrument;
import Part_C.midi.Midi;
import Part_C.music.NoteEvent;
import Part_C.music.NoteEvent.Kind;
import Part_C.music.Pitch;

public class PianoMachine {

    private Midi midi;
    private Instrument instr = Midi.DEFAULT_INSTRUMENT;
    private List<NoteEvent> noteEventRecords = new ArrayList<>();

    private int semiTonesShift = 0;
    private boolean isRecording = false;

    /**
     * constructor for PianoMachine.
     * <p>
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    /**
     * if the there's no playing pitch or playing pitches does not contain rawPitch,
     * start playing the note with rawPitch
     *
     * @param rawPitch Pitch to be played next
     */
    public void beginNote(Pitch rawPitch) {
        Pitch nextPitch = rawPitch.transpose(semiTonesShift);

        if (isRecording) {
            long time = (long) (System.currentTimeMillis() / 10.0);
            noteEventRecords.add(new NoteEvent(nextPitch, time, instr,
                    Kind.start));
        }

        midi.beginNote(nextPitch.toMidiFrequency(), instr);

    }


    /**
     * if the playing pitches contain rawPitch,
     * stop playing rawPitch
     *
     * @param rawPitch Pitch to be played next
     */
    public void endNote(Pitch rawPitch) {
        Pitch nextPitch = rawPitch.transpose(semiTonesShift);

        if (isRecording) {
            long time = (long) (System.currentTimeMillis() / 10.0);
            noteEventRecords.add(new NoteEvent(nextPitch, time, instr,
                    Kind.stop));
        }

        midi.endNote(nextPitch.toMidiFrequency(), instr);
    }


    /**
     * change instruments to the next one in the order specified in Instrument enum
     */
    public void changeInstrument() {
        instr = instr.next();
    }

    /**
     * if the notes isn't already shifted up by two octaves (24 semitones),
     * shift the notes up by one octave (12 semitones)
     */
    public void shiftUp() {
        if (semiTonesShift <= Pitch.OCTAVE * 2) {
            semiTonesShift += Pitch.OCTAVE;
        }
    }

    /**
     * if the notes isn't already shifted down by two octaves (24 semitones),
     * shift the notes down by one octave (12 semitones)
     */
    public void shiftDown() {
        if (semiTonesShift >= Pitch.OCTAVE * -2) {
            semiTonesShift -= Pitch.OCTAVE;
        }
    }

    /**
     * if not recording, toggle it on and clear the records
     * if recording, toggle it off
     *
     * @return boolean isRecording determines whether to start recording or not
     */
    public boolean toggleRecording() {
        if (!isRecording) {
            isRecording = true;
            noteEventRecords = new ArrayList<>();
        } else {
            isRecording = false;
        }

        return isRecording;
    }

    /**
     * loop through the records and play all the notes in the records
     * if the note is not the last in the records, put a rest time right after it
     */
    public void playback() {
        int recordsLength = noteEventRecords.size();

        for (int i = 0; i < recordsLength; i++) {
            NoteEvent noteEvent = noteEventRecords.get(i);
            Kind noteEventKind = noteEvent.getKind();

            if (noteEventKind == Kind.start) {
                midi.beginNote(noteEvent.getPitch().toMidiFrequency(), noteEvent.getInstr());
            } else {
                midi.endNote(noteEvent.getPitch().toMidiFrequency(), noteEvent.getInstr());
            }

            if (i < recordsLength - 1) {
                NoteEvent nextNoteEvent = noteEventRecords.get(i + 1);
                int restTime = (int) ((nextNoteEvent.getTime() - noteEvent.getTime()));
                Midi.rest(restTime);
            }

        }
    }

}
