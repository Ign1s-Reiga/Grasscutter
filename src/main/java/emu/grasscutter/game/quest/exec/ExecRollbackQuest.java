package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestManager;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.server.packet.send.PacketScenePlayerLocationNotify;

@QuestValue(QuestTrigger.QUEST_EXEC_ROLLBACK_QUEST)
public class ExecRollbackQuest extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        var targetQuestId = Integer.parseInt(paramStr[0]);
        var targetQuest = quest.getOwner().getQuestManager().getQuestById(targetQuestId);
        var targetPosition = targetQuest.getMainQuest().rewindTo(targetQuest, true);
        if(targetPosition == null){
            return false;
        }
        quest.getOwner().getPosition().set(targetPosition.get(0));
        quest.getOwner().getRotation().set(targetPosition.get(1));
        quest.getOwner().sendPacket(new PacketScenePlayerLocationNotify(quest.getOwner().getScene()));
        // todo proper reset and warp
        return true;
    }
}
