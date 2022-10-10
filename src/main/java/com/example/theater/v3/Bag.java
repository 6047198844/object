package com.example.theater.v3;

public class Bag {
    public Bag(Long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) { // 이벤트에 당첨된 관람객이라면
            setTicket(ticket); // 티켓을 가방에 넣어준다.
            return 0L;
        } else { // 이벤트에 당첨되지 않은 관람객이라면
            setTicket(ticket); // 티켓을 가방에 넣어준다.
            minusAmount(ticket.getFee()); // 관람객의 가방에서 티켓 금액을 차감한다.
            return ticket.getFee();
        }
    }
    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
