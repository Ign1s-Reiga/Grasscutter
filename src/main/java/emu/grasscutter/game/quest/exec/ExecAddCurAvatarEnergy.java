package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass.PropChangeReason;

@QuestValue(QuestTrigger.QUEST_EXEC_ADD_CUR_AVATAR_ENERGY)
public class ExecAddCurAvatarEnergy extends QuestExecHandler {

    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        quest.getOwner().getTeamManager().getActiveTeam().forEach(v -> {
            int amount = (int) v.getFightProperty(v.getAvatar().getSkillDepot().getElementType().getMaxEnergyProp());
            v.addEnergy(amount, PropChangeReason.PROP_CHANGE_REASON_GM);
        });
        return true;
    }
}
