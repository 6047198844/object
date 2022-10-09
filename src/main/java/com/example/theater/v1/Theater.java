package com.example.theater.v1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 가방 안에 초대장이 들어 잇는지 확인한다.
        if (audience.getBag().hasInvitation()) { // 이벤트에 당첨된 관람객이라면
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket); // 티켓을 가방에 넣어준다.
        } else { // 이벤트에 당첨되지 않은 관람객이라면
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee()); // 관람객의 가방에서 티켓 금액을 차감한다.
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 매표소의 금액을 증가시킨다.
            audience.getBag().setTicket(ticket); // 티켓을 가방에 넣어준다.
        }
    }
}
