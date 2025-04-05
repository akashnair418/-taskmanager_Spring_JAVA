package com.scalar.taskmanager.dto;

import com.scalar.taskmanager.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteResponseDTO {
    private Integer taskId;
    private NoteEntity note;
}
