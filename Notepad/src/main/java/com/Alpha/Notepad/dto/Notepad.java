package com.Alpha.Notepad.dto;

import java.util.Objects;

public class Notepad {
	private int notepadId;
	private String notepadTitle;
	private String notepadContent;
	@Override
	public int hashCode() {
		return Objects.hash(notepadContent, notepadId, notepadTitle);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notepad other = (Notepad) obj;
		return Objects.equals(notepadContent, other.notepadContent) && notepadId == other.notepadId
				&& Objects.equals(notepadTitle, other.notepadTitle);
	}
	@Override
	public String toString() {
		return "Notepad [notepadId=" + notepadId + ", notepadTitle=" + notepadTitle + ", notepadContent="
				+ notepadContent + "]";
	}

	

	public Notepad(int int1, String string, String string2) {
		this.notepadId = int1;
		this.notepadTitle = string;
		this.notepadContent = string2;
		
	}
	public Notepad() {
		
	}

	public int getNotepadId() {
		return notepadId;
	}

	public void setNotepadId(int notepadId) {
		this.notepadId = notepadId;
	}

	public String getNotepadTitle() {
		return notepadTitle;
	}

	public void setNotepadTitle(String notepadTitle) {
		this.notepadTitle = notepadTitle;
	}

	public String getNotepadContent() {
		return notepadContent;
	}

	public void setNotepadContent(String notepadContent) {
		this.notepadContent = notepadContent;
	}
	
}
