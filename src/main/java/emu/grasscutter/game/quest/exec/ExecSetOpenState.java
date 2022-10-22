package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData.QuestExecParam;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_SET_OPEN_STATE)
public class ExecSetOpenState extends QuestExecHandler {

    @Override
    public boolean execute(GameQuest quest, QuestExecParam condition, String... paramStr) {
        int openState = Integer.parseInt(paramStr[0]);
        int value = Integer.parseInt(paramStr[1]);
        quest.getOwner().getProgressManager().setOpenStateFromClient(openState, value);
        return true;
    }
}
