package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_SET_OPEN_STATE)
public class ExecSetIsFlyable extends QuestExecHandler {

    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        int isFlyable = Integer.parseInt(paramStr[0]);
        if (!quest.getOwner().setProperty(PlayerProperty.PROP_IS_FLYABLE, isFlyable))
            return false;
        quest.getOwner().save();
        return true;
    }
}
